//js中利用pageContext.request.contextPath不能获取项目路径
//js获取项目根路径，如： http://localhost:8080/letus179
function getRootPath(){
    //获取当前网址，如： http://localhost:8080/letus179/register/register.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： letus179/register/register.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8080
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/letus179
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}
