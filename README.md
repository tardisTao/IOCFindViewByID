# IOCFindViewByID
初始导入，用于练习注解

1. 注解的代码写在baselibrary库中，项目使用只需要添加baselibrary
2. baselibrary功能分为属性注入、方法注入;
3. todolist:checkNetwork,用于检测网络(待完善)

* 使用方式：

1.添加依赖<br>
2.在Activity或者Fragment中添加  <br>
ViewUtils.inject(this); <br>
3. 属性注入：<br>
``` ViewUtils.inject(this); ```<br>
4. 方法注入<br>
``` @OnClick(R.id.btn2)
    private void OnClick(){
        Toast.makeText(this,"button 2 点击了",Toast.LENGTH_SHORT).show();
    } ```


