# IOCFindViewByID
初始导入，用于练习注解
1.注解的代码写在baselibrary库中，项目使用只需要添加baselibrary
2.baselibrary功能分为属性注入、方法注入

使用方式：
1.添加依赖
2.在Activity或者Fragment中添加  
ViewUtils.inject(this); 
3.属性注入：
 @ViewById(R.id.btn1)
 Button mButton1;
4.方法注入：
  @OnClick(R.id.btn2)
    private void OnClick(){
        Toast.makeText(this,"button 2 点击了",Toast.LENGTH_SHORT).show();
    }

