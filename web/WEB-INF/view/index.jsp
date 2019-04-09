<%--
  Created by IntelliJ IDEA.
  User: LM16
  Date: 2019/3/28
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <style>
      body{
          font-size: 18px;
          line-height: 1.7;
          margin: 0 20%;
      }
      .top-nav{
          background: #eee;
          margin-top: 50px;
      }
      .top-nav a{
          text-decoration: none;
          color:#666;
          padding:6px 20px;
      }
      .wrapper{
          height:1000px;
          background: #f5f5f5;
      }
      .wrapper div{

          overflow: hidden;
      }
      .wrapper ul, li{
        list-style:none;
        float:left;
      }
      .wrapper li{
        display: block;
        margin: 0 20px;
        width: 230px;
      }
    </style>
  </head>
  <body>
    <div class="top-nav">
        <div>
            <span>欢迎您：<em id="phone"></em></span>
            <a href="">切换卡号</a>
            <a href="/logout.do">退出登录</a>
        </div>
        <div></div>
        <div style="margin-top: 10px">
            <span>您当前使用的卡号为：<em id="card"></em></span>
        </div>
    </div>
    <div class="wrapper">
        <div>
            <ul>
                <li>
                    <p>余额</p>
                    <button id="toggle">显示余额</button><br>
                    <span id="show" style="font-size: 16px; color: red; display: block; margin:10px"></span>
                </li>
            </ul>
        </div>
        <hr>
        <div>
          <ul>
              <li>
                  <p>存款</p>
                  请输入金额：<input type="text" id="add">
                  <button id="b_add">确定</button>
              </li>
              <li>
                  <p>取款</p>
                  请输入金额：<input type="text" id="subtract">
                  <button id="b_subtract">确定</button>
              </li>
              <li>
                  <p>转账</p>
                  请输入金额：<input type="text" id="to"><br>
                  请输入对方卡号：<input type="text" id="target">
                  <button id="b_to">确定</button>
              </li>
            </ul>
        </div>
        <hr>
        <div>
            <ul>
                <li>
                    <p>交易记录</p>
                    <a href="/bill.do">
                        <button>跳转</button>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <script src="../../js/jquery.min.js"></script>
    <script>
      $(function(){

          var phone = "${sessionScope.account.phone}".replace(/(\d{3})\d{5}(\d{3})/, "$1*****$2");
          var card = "${sessionScope.card.cardId}".replace(/(\d{5})\d+(\d{5})/, "$1*********$2");

          $('#phone').html(phone);
          $('#card').html(card);
          //余额已获取
          $('#show').css("visibility", "hidden");
          show();

          /*查询操作*/
          $('#toggle').on('click',function () {

              if($('#show').css("visibility")==="hidden"){
                  $('#show').css("visibility", "visible");
              }else{
                  $('#show').css("visibility", "hidden");
              }
              if($('#toggle').text()==="显示余额") {
                  $('#toggle').text('隐藏余额');
              }else{
                  $('#toggle').text('显示余额');
              }
          });

          /*存款操作*/
          $('#b_add').on('click',function () {

              if(!/(?!^0*(\.0{1,2})?$)^\d{1,6}(\.\d{1,2})?$/.test($('#add').val())){
                  alert('检查下输入值？');
                  return
              }

              $.ajax({
                  url: "/update.do",
                  type: "POST",

                  contentType : "application/json;charset=UTF-8",
                  data: JSON.stringify({"cardId":'${sessionScope.card.cardId}', "type":0, "changee":$('#add').val().trim()}),

                  success: function(data) {
                      $('#add').val("");

                      if(/^\d+.\d+$/.test(data)) {
                          alert('存款成功');
                          $('#show').html(data);
                      }else{
                          alert(data);
                      }
                  }
              })
          });

          /*取款操作*/
          $('#b_subtract').on('click', function () {

              if(!/([1-9]\d{0,5}|0)(\.[1-9]{1,2}|\.0[1-9])?/.test($('#subtract').val())){
                  alert('检查下输入值？');
                  return
              }

              $.ajax({
                  url: "/update.do",
                  type: "POST",

                  contentType : "application/json;charset=UTF-8",
                  data: JSON.stringify({"cardId": '${sessionScope.card.cardId}', "type":1, "changee":$('#subtract').val().trim()}),

                  success: function(data) {
                      $('#subtract').val("");

                      if(/^\d+.\d+$/.test(data)) {
                          alert('取款成功');
                          $('#show').html(data);
                      }else{
                          alert(data);
                      }
                  }
              })
          });

          /*转帐操作*/
          $('#b_to').on('click', function () {

              if(!/([1-9]\d{0,5}|0)(\.[1-9]{1,2}|\.0[1-9])?/.test($('#to').val())){
                  alert('检查下输入值？');
              }else if(!/[1-6]{1}(\d{15}|\d{18})/.test($('#target').val())){
                  alert('检查下卡号？');
              }else{
                  $.ajax({
                      url: "/turn.do",
                      type: "POST",

                      contentType : "application/json;charset=UTF-8",
                      data: JSON.stringify({"a":{"cardId": '${sessionScope.card.cardId}', "type":10, "changee":$('#to').val().trim()}, "b":{"cardId": $('#target').val().trim(),  "type":11, "changee":$('#to').val().trim()}}),

                      success: function(data) {
                          $('#to').val("");
                          $('#target').val("");
                          if(/^\d+.\d+$/.test(data)) {
                              alert('转帐成功');
                              $('#show').html(data);
                          }else{
                              alert(data);
                          }
                      }
                  })
              }
          });

      });

      function show(){
          $.ajax({
              url: "/show.do",
              type: "POST",

              contentType : "application/json;charset=UTF-8",
              data: JSON.stringify({"cardId":'${sessionScope.card.cardId}'}),

              success: function(data) {
                  $('#show').html(data);
              }
          });
      }
    </script>
  </body>
</html>
