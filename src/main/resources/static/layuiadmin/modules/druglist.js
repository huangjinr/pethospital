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
    elem: '#LAY-drug-list'
    ,url: '/drug/selectDrugList' //模拟接口
    ,cols: [[
      {type: 'numbers', fixed: 'left'}
      ,{field: 'drugName', width: '10%', title: '药品名称'}
      ,{field: 'drugPrice', title: '药品价格', width: '10%'}
      ,{field: 'drugSize', title: '药品库存',width: '10%'}
      ,{field: 'drugType', title: '药品类别',width: '10%'}
      ,{field: 'drugDetail', title: '药品详情',width: '32.6%'}
      ,{field: 'drugImage', title: '药品图片',width: '10%', templet: '<div><img width="70px" height="48px" src="/{{d.drugImage}}"></div>'}
      ,{title: '操作', width: '15%', align: 'center', fixed: 'right', toolbar: '#table-content-list'}
    ]]
    ,page: false
    ,text: '对不起，加载出现异常！'
  });
  
  //监听工具条
  table.on('tool(LAY-app-content-list)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('确定删除此文章？', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.open({
        type: 2
        ,title: '编辑文章'
        ,content: '../../../views/app/content/listform.html?id='+ data.id
        ,maxmin: true
        ,area: ['550px', '550px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
          ,submit = layero.find('iframe').contents().find("#layuiadmin-app-form-edit");

          //监听提交
          iframeWindow.layui.form.on('submit(layuiadmin-app-form-edit)', function(data){
            var field = data.field; //获取提交的字段
            
            //提交 Ajax 成功后，静态更新表格中的数据
            //$.ajax({});              
            obj.update({
              label: field.label
              ,title: field.title
              ,author: field.author
              ,status: field.status
            }); //数据更新
            
            form.render();
            layer.close(index); //关闭弹层
          });  
          
          submit.trigger('click');
        }
      });
    }
  });


  exports('druglist', {})
});