/**

 @Name：layuiAdmin 用户管理 管理员管理 角色管理
 @Author：star1029
 @Site：http://www.layui.com/admin/
 @License：LPPL
    
 */


layui.define(['table', 'form'], function(exports){
  var $ = layui.$
  ,table = layui.table
  ,form = layui.form;


  var name = document.getElementById('name').value;
  var username = document.getElementById('username').value;
  var phone = document.getElementById('phone').value;

  //用户管理
  table.render({
    elem: '#LAY-user-manage'
    , url: '/user/selectUserList' //模拟接口
    , cols: [[
      {type: 'checkbox', fixed: 'left'}
      , {field: 'name', title: '姓名', width: '10%'}
      , {field: 'username', title: '账号', width: '10%'}
      , {field: 'phone', title: '手机', width: '15%'}
      , {field: 'sex', width: '10%', title: '性别',templet:function (d) {
          if(d.sex == 1){
            return '男'
          }else if(d.sex == 2) {
            return '女'
          }
        }}
      , {field: 'role.name', width: '10%', title: '角色',templet:function (d) {
          return d.role.name
        }}
      , {field: 'address', width: '30%', title: '地址'}
      , {title: '操作', width: '15%', align: 'center', fixed: 'right', toolbar: '#table-useradmin-webuser'}
    ]]
    , page: false
    , limit: 30
    , height: 'full-220'
    , text: '对不起，加载出现异常！'
  });
  
  //监听工具条
  table.on('tool(LAY-user-manage)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('真的删除吗', function (index) {
        $.ajax({
          url: "/user/deleteUserById?id="+data.id,
          type: "get",
          async: false,
          success: function (data) {
            layer.msg("删除成功");
          },
          error: function (data) {
            layer.msg("删除失败");
          }
        });
        table.reload('LAY-user-manage');
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      var tr = $(obj.tr);

      layer.open({
        type: 2
        ,title: '编辑用户'
        ,content: '/user/updateUserIndex?id=' + data.id
        ,maxmin: true
        ,area: ['500px', '450px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
          ,submitID = 'LAY-user-front-submit'
          ,submit = layero.find('iframe').contents().find('#'+ submitID);

          //监听提交
          iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
            var field = data.field; //获取提交的字段
            
            //提交 Ajax 成功后，静态更新表格中的数据
            //$.ajax({});
            $.ajax({
              type: "post",
              /*contentType: "application/json;charset=UTF-8",*/
              url: "/user/updateUser",
              data: field,
              async: false,
              success: function (data) {
                layer.msg("编辑成功");
              },
              error: function (e) {
                layer.msg("编辑失败");
              }
            })
            table.reload('LAY-user-manage');
            layer.close(index); //关闭弹层
          });  
          
          submit.trigger('click');
        }
        ,success: function(layero, index){
          
        }
      });
    }
  });

  exports('useradmin', {})
});