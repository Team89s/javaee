package com.igeek.ch04.controller;

import com.igeek.ch04.entity.Items;
import com.igeek.ch04.service.ItemsService;
import com.igeek.ch04.vo.PageVO;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

@WebServlet(name = "ItemsServlet" , urlPatterns = "/items")
//当前Servlet接收multipart/form-data请求, 将一个Servlet标识为支持文件上传
@MultipartConfig
public class ItemsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ItemsService service = new ItemsService();
        String code = request.getParameter("code");

        if(code!=null && !"".equals(code)){
            switch (code){
                case "viewAll":
                    //获取当前页码
                    String page = request.getParameter("pageNow");
                    int pageNow = 0;
                    if(page == null){
                        pageNow = 1;  //默认查询第一页
                    }else{
                        pageNow = Integer.parseInt(page);
                    }

                    //获取当前查询条件
                    String query = request.getParameter("query");
                    if(query ==null){
                        query = "";  //默认没有条件，查询所有
                    }

                    PageVO<Items> pageVO = service.viewAll(query, pageNow);
                    request.setAttribute("vo",pageVO);
                    request.getRequestDispatcher("items/itemsList.jsp").forward(request,response);
                    break;
                case "validate":
                    String name = request.getParameter("name");
                    boolean flag = service.validate(name);
                    String message = "";
                    if(flag){
                        message = "当前商品名称可以使用";
                    }else{
                        message = "当前商品名称已被占用";
                    }

                    //以json数据格式，将flag、message的值传递至页面
                    JSONObject obj = new JSONObject();
                    //将两个数据绑定到json数据上
                    obj.put("flag",Boolean.toString(flag));
                    obj.put("message",message);

                    //通过响应获得输出流
                    PrintWriter out = response.getWriter();
                    //将json数据以字符串的形式写到页面中
                    out.println(obj.toString());
                    out.flush();
                    out.close();

                    break;
                case "add":
                    //收集普通域中的请求参数
                    name = request.getParameter("name");
                    String detail = request.getParameter("detail");
                    Double price = Double.valueOf(request.getParameter("price"));
                    Timestamp createtime = Timestamp.valueOf(request.getParameter("createtime"));
                    //封装商品对象
                    Items items = new Items(name,price,createtime,detail);

                    //收集图片上传的请求参数
                    Part part = request.getPart("file");
                    if(part!=null){
                        //获取上传时图片信息（包含图片名称）
                        String oldName = part.getHeader("content-disposition");
                        //oldName = form-data; name="file"; filename="car1.png"
                        System.out.println("oldName = "+oldName);

                        if(oldName!=null && oldName.lastIndexOf(".")>0){
                            //真正上传图片
                            //图片新名字 = 随机数 + 旧名称的后缀
                            String newName = UUID.randomUUID()
                                    + oldName.substring(oldName.lastIndexOf("."),oldName.length()-1);

                            //将图片信息存储至当前的Items对象中
                            items.setPic("/pic/"+newName);
                            //将图片信息传递至本地服务器上
                            part.write("E:\\5.JSP+Servlet\\temp\\"+newName);
                        }
                    }

                    //添加商品
                    boolean o = service.add(items);
                    if(o){
                        //添加成功，为了避免重复提交表单，响应重定向至查询商品列表
                        response.sendRedirect(request.getContextPath()+"/items?code=viewAll");
                    }else{
                        //添加失败，回显商品信息
                        request.setAttribute("items",items);
                        request.getRequestDispatcher("/items/addItem.jsp").forward(request,response);
                    }

                    break;
                case "viewOne":
                    int id = Integer.parseInt(request.getParameter("id"));
                    items = service.viewOne(id);
                    request.setAttribute("items",items);
                    request.getRequestDispatcher("items/editItem.jsp").forward(request,response);
                    break;
                case "update":
                    //收集普通域中的请求参数
                    id = Integer.parseInt(request.getParameter("id"));
                    name = request.getParameter("name");
                    detail = request.getParameter("detail");
                    price = Double.valueOf(request.getParameter("price"));
                    createtime = Timestamp.valueOf(request.getParameter("createtime"));
                    //封装商品对象
                    items = new Items(id,name,price,createtime,detail);

                    //收集图片上传的请求参数
                    part = request.getPart("file");
                    if(part!=null){
                        String oldName = part.getHeader("content-disposition");
                        if(oldName!=null && oldName.lastIndexOf(".")>0){
                            //上传
                            String newName = UUID.randomUUID() +
                                    oldName.substring(oldName.lastIndexOf("."),oldName.length()-1);
                            //给Items对象传递图片信息
                            items.setPic("/pic/"+newName);
                            //本地图片服务器传递图片信息
                            part.write("E:\\5.JSP+Servlet\\temp\\"+newName);
                        }else{
                            //未上传
                            String pic = service.viewOne(id).getPic();
                            items.setPic(pic);
                        }
                    }

                    o = service.update(items);

                    if(o){
                        //更新成功 ， 响应重定向，避免重复提交表单
                        response.sendRedirect(request.getContextPath()+"/items?code=viewAll");
                    }else{
                        //更新失败 ， 数据回显
                        request.setAttribute("items",service.viewOne(id));
                        request.getRequestDispatcher("items/editItem.jsp").forward(request,response);
                    }

                    break;
                case "delete":
                    String[] strs = request.getParameterValues("id");
                    Integer[] ids = new Integer[strs.length];
                    for (int i = 0; i < strs.length; i++) {
                        ids[i] = Integer.parseInt(strs[i]);
                    }
                    service.delete(ids);
                    response.sendRedirect(request.getContextPath()+"/items?code=viewAll");
                    break;
                default:
                    System.out.println("没有匹配操作项");
                    break;
            }
        }

    }
}
