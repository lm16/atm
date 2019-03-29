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
      ul li{
        list-style:none;
        float: left;
        margin: 15px 20px;
        width: 230px;
      }
    </style>
  </head>
  <body>
      <div class="wrapper">
        <ul>
          <li>
            <div>
              <p>欢迎您：${sessionScope.account.phone}</p>
              <p>您当前使用的卡号为：${sessionScope.card.cardId}</p>
            </div>
          </li>
          <li>
            <div>
              <p>余额</p>
              <button id="toggle">显示余额</button>
              <div id="show" style="font-size: 16px; color: red;">
              </div>
            </div>
          </li>
          <li>
            <div>
              <p>存款</p>
              请输入金额：<input type="text" id="add">
              <button id="b_add">确定</button>
            </div>
          </li>
          <li>
            <div>
              <p>取款</p>
              请输入金额：<input type="text" id="subtract">
              <button id="b_subtract">确定</button>
            </div>
          </li>
          <li>
            <div>
              <p>转账</p>
              请输入金额：<input type="text" id="transfer"><br>
              请输入对方卡号：<input type="text" id="target">
              <button id="b_transfer">确定</button>
            </div>
          </li>
          <li>
            <div>
              <p>修改支付密码</p>
              请输入原密码：<input type="text" id="passwd1"><br>
              请输入新密码：<input type="text" id="passwd2">
              <button id="b_passwd">确定</button>
            </div>
          </li>
          <li>
            <div>
              <p>申请解冻</p>
              请输入姓名：<input type="text" id="frozen1"><br>
              请输入身份证号：<input type="text" id="frozen2">
              <button id="b_frozen">确定</button>
            </div>
          </li>
          <li>
            <div>
              <p>申请挂失</p>
              请输入姓名：<input type="text" id="loss1"><br>
              请输入身份证号：<input type="text" id="loss2">
              <button id="b_loss">确定</button>
            </div>
          </li>
          <li>
            <div>
              <div>
                <p>注销此卡</p>
                请输入姓名：<input type="text" id="drop1"><br>
                请输入身份证号：<input type="text" id="drop2">
                <button id="b_drop">确定</button>
              </div>
            </div>
          </li>
        </ul>
      </div>

      <script src="js/jquery.min.js"></script>
      <script>
          $(function(){
              //余额已获取
              $('#show').toggle();
              show();

              /*查询操作*/
              $('#toggle').on('click',function () {

                  $('#show').toggle();
                  if($('#toggle').text()==="显示余额") {
                      $('#toggle').text('隐藏余额');
                  }else{
                      $('#toggle').text('显示余额');
                  }
              });

              /*存款操作*/
              $('#b_add').on('click',function () {
                  $.ajax({
                      url: "/update.do",
                      type: "POST",

                      contentType : "application/json;charset=UTF-8",
                      data: JSON.stringify({"a":{"cardId":${sessionScope.card.cardId}}, "to":{ "type":0, "change":$('#add').val().trim()},"b":{}}),

                      success: function(data) {
                          $('#add').val("");
                          alert(data+'存款成功');
                          show();
                      }
                  })
              });

              /*取款操作*/
              $('#b_subtract').on('click', function () {
                  $.ajax({
                      url: "/update.do",
                      type: "POST",

                      contentType : "application/json;charset=UTF-8",
                      data: JSON.stringify({"a": {"cardId": ${sessionScope.card.cardId}}, "to":{ "type":1, "change":$('#subtract').val().trim()},"b":{}}),

                      success: function(data) {
                          $('#subtract').val("");
                          alert(data+'取款成功');
                          show();
                      }
                  })
              });

              /*转帐操作*/
              $('#b_transfer').on('click', function () {
                  $.ajax({
                      url: "/update.do",
                      type: "POST",

                      data: JSON.stringify({"a":{"cardId":${sessionScope.card.cardId}}, "to":{ "type":2, "change":$('#transfer').val().trim()},"b":{"cardId":$('#target').val().trim()}}),
                      contentType : "application/json;charset=UTF-8",

                      success: function(data) {
                          $('#transfer').val("");
                          $('#target').val("");
                          alert(data+'转帐成功');
                          show();
                      }
                  })
              })
          });

          function show(){
              $.ajax({
                  url: "/show.do",
                  type: "POST",

                  contentType : "application/json;charset=UTF-8",
                  data: JSON.stringify({"cardId":${sessionScope.card.cardId}}),

                  success: function(data) {
                      $('#show').html(data);
                  }
              });
          }
      </script>
  </body>
</html>
