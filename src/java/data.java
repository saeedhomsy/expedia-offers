/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;

public class data extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {   
            JSONObject json = readData.readJsonFromUrl("https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel");
            JSONArray hotelsArr = json.getJSONObject("offers").getJSONArray("Hotel");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Expedia Test</title>"); 
            out.println("<link rel='shortcut icon' href='https://www.expedia.com/favicon.ico' />");
            out.println("<link href='//www.jqueryscript.net/css/jquerysctipttop.css' rel='stylesheet' type='text/css'>"); 
            out.println("<link rel='stylesheet' href='//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css'>"); 
            out.println("<style type='text/css'>"); 
            out.println(".paging-nav {text-align: right;padding-top: 2px;}");
            out.println(".paging-nav a {margin: auto 1px;text-decoration: none;display: inline-block;padding: 1px 7px;background: #91b9e6;color: white;border-radius: 3px;}");
            out.println(".paging-nav .selected-page {background: #187ed5;font-weight: bold;}");
            out.println(".paging-nav,#tableData {width: 95%;margin: 0 auto;font-family: Arial, sans-serif;}");
            out.println("</style>"); 
            out.println("</head>");
            out.println("<body>");   
            StringBuilder sb = new StringBuilder();
            sb.append("<table id='tableData' class='table table-bordered table-striped'><thead><tr>");
            sb.append("<th>Order</th><th>Image</th><th>Name</th><th>City</th><th>Language</th><th>Image</th><th>Image</th>");
            sb.append("<th>Rating</th><th>Image</th><th>Image</th><th>Image</th><th>map</th>");
            sb.append("</tr></thead><tbody>");
            for(int i=0;i<hotelsArr.length();i++){
                sb.append("<tr><td>").append(i+1).append("</td>");
                sb.append("<td><img src='").append(hotelsArr.getJSONObject(i).getJSONObject("hotelInfo").get("hotelImageUrl")).append("' width='100' height='100'/></td>");
                sb.append("<td>").append(hotelsArr.getJSONObject(i).getJSONObject("hotelInfo").get("hotelName")).append("</td>");
                sb.append("<td>").append(hotelsArr.getJSONObject(i).getJSONObject("hotelInfo").get("hotelCity")).append("</td>");
                sb.append("<td>").append(hotelsArr.getJSONObject(i).getJSONObject("hotelInfo").get("language")).append("</td>");
                sb.append("<td>").append(hotelsArr.getJSONObject(i).getJSONObject("hotelInfo").get("promotionAmount")).append("</td>");
                sb.append("<td>").append(hotelsArr.getJSONObject(i).getJSONObject("hotelInfo").get("promotionDescription")).append("</td>");
                sb.append("<td>").append(hotelsArr.getJSONObject(i).getJSONObject("hotelInfo").get("hotelGuestReviewRating")).append("</td>");
                sb.append("<td>").append(hotelsArr.getJSONObject(i).getJSONObject("hotelInfo").get("description")).append("</td>");
                sb.append("<td>").append(hotelsArr.getJSONObject(i).getJSONObject("hotelInfo").get("travelStartDate")).append("</td>");
                sb.append("<td>").append(hotelsArr.getJSONObject(i).getJSONObject("hotelInfo").get("travelEndDate")).append("</td>");
                sb.append("<td>").append("<a href='hoteldetails?id=" + hotelsArr.getJSONObject(i).getJSONObject("hotelInfo").get("hotelId")  + "'>doing</a>").append("</td></tr>");
            }
            sb.append("</tbody></table>");
            out.println(sb.toString());
            out.println("<script type='text/javascript' src='//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js'></script>");
            out.println("<script src='//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>");
            out.println("<script type='text/javascript' src='//rawgit.com/saeedhomsy/test/master/paging.js'>");
            out.print("</script>");
            out.println("<script type='text/javascript'>");
            out.println("$(document).ready(function() {$('#tableData').paging({limit:5});});");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
            } catch (JSONException ex) {
                Logger.getLogger(data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
