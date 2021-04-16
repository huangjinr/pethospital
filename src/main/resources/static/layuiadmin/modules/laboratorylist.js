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

  table.render({
    elem: '#LAY-laboratory-list'
    ,url: '/laboratory/selectLaboratoryList' //模拟接口
    ,cols: [[
      {type: 'numbers', fixed: 'left'}
      ,{field: 'user.name', width: '15%', title: '顾客姓名', templet:function (d) {
          return d.user.name
        }}
      ,{field: 'user.animal', title: '宠物类型', width: '15%', templet:function (d) {
          return d.user.animal
        }}
      ,{field: 'user.animalName', title: '宠物姓名',width: '12.6%', templet:function (d) {
          return d.user.animalName
        }}
      ,{field: 'laboratoryReport', title: '化验结果',width: '30%'}
      ,{field: 'laboratoryImage', title: '化验图片',width: '10%', templet: '<div><img width="70px" height="48px" src="/{{d.laboratoryImage}}"></div>'}
      ,{title: '操作', width: '15%', align: 'center', fixed: 'right', toolbar: '#table-content-list'}
    ]]
    ,page: false
    ,text: '对不起，加载出现异常！'
  });
  
  //监听工具条
  table.on('tool(LAY-laboratory-list)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function (index) {
        $.ajax({
          url: "/laboratory/deleteLaboratoryById?id=" + data.id,
          type: "get",
          async: false,
          success: function (data) {
            layer.msg("删除成功");
          },
          error: function (data) {
            layer.msg("删除失败");
          }
        });
        table.reload('LAY-laboratory-list');
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.open({
        type: 2
        ,title: '编辑文章'
        ,content: '/laboratory/updateLaboratoryIndex?id='+ data.id
        ,maxmin: true
        ,area: ['550px', '550px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
          ,submit = layero.find('iframe').contents().find("#layuiadmin-laboratory-edit");

          //监听提交
          iframeWindow.layui.form.on('submit(layuiadmin-laboratory-edit)', function(data){
            var field = data.field; //获取提交的字段
            
            //提交 Ajax 成功后，静态更新表格中的数据
            //$.ajax({});

            $.ajax({
              type: "post",
              /*contentType: "application/json;charset=UTF-8",*/
              url: "/laboratory/updateLaboratory",
              data: field,
              async: false,
              success: function (data) {
                layer.msg("编辑成功");
              },
              error: function (e) {
                layer.msg("编辑失败");
              }
            })
            table.reload('LAY-laboratory-list'); //数据刷新
            layer.close(index); //关闭弹层
          });  
          
          submit.trigger('click');
        }
      });
    }
  });


  exports('laboratory', {})
});