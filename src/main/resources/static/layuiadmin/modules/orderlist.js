/**

 @Name：layuiAdmin 内容系统
 @Author：star1029
 @Site：http://www.layui.com/admin/
 @License：LPPL
    
 */


layui.define(['table', 'form'], function(exports){
  var $ = layui.$
  ,table = layui.table
  ,form = layui.form;

  //文章管理
  table.render({
    elem: '#LAY-order-list'
    ,url: '/order/selectOrderList' //模拟接口
    ,cols: [[
      {type: 'numbers', fixed: 'left'}
      ,{field: 'id', width: '16%', title: '订单编号'}
      ,{field: 'userName', width: '10%', title: '订单顾客名称'}
      ,{field: 'animal', title: '宠物类别',width: '10%'}
      ,{field: 'animalName', title: '宠物姓名',width: '10%'}
      ,{field: 'drugName', title: '订单药品名称', width: '25%'}
      ,{field: 'totalPrice', title: '总价格',width: '10%'}
      ,{title: '操作', width: '15%', align: 'center', fixed: 'right', toolbar: '#table-content-list'}
    ]]
    ,page: false
    ,text: '对不起，加载出现异常！'
  });
  
  //监听工具条
  table.on('tool(LAY-order-list)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('真的删除么', function (index) {
        debugger;
        $.ajax({
          url: "/order/deleteOrderByBuyId?id=" + data.id,
          type: "get",
          async: false,
          success: function (data) {
            layer.msg("删除成功");
          },
          error: function (data) {
            layer.msg("删除失败");
          }
        });
        table.reload('LAY-order-list');
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.open({
        type: 2
        ,title: '编辑订单'
        ,content: '/order/updateOrderIndex?id='+ data.id
        ,maxmin: true
        ,area: ['550px', '550px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
          ,submit = layero.find('iframe').contents().find("#layuiadmin-order-edit");

          //监听提交
          iframeWindow.layui.form.on('submit(layuiadmin-order-edit)', function(data){
            var field = data.field; //获取提交的字段
            
            //提交 Ajax 成功后，静态更新表格中的数据
            //$.ajax({});

            $.ajax({
              type: "post",
              /*contentType: "application/json;charset=UTF-8",*/
              url: "/order/updateOrder",
              data: field,
              async: false,
              success: function (data) {
                layer.msg("编辑成功");
              },
              error: function (e) {
                layer.msg("编辑失败");
              }
            })
            table.reload('LAY-order-list'); //数据刷新
            layer.close(index); //关闭弹层
          });  
          
          submit.trigger('click');
        }
      });
    }
  });


  exports('orderlist', {})
});