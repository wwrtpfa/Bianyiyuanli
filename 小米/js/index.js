// var c=document.getElementById("tabs");
// 定义时间提示栏的动作，点击之后背景字体变色
var tabs = document.getElementById("tabs").getElementsByTagName("li");
var uls = document.getElementById("uls").getElementsByTagName("ul");
// console.log(tabs);
for (var i = 0; i < tabs.length; i++) {
    tabs[i].onclick = showlist;

}
function showlist() {
    for (var i = 0; i < tabs.length; i++) {
        if (tabs[i] === this) {
            console.log(tabs[i]);
            tabs[i].className = "active";
            uls[i].className = "clear-fixed active";
        }
        else {
            tabs[i].className = "";
            uls[i].className = "clear-fixed";
        }


    }
}
var sc = document.getElementById("scro");
window.onscroll = function () {
    var scro = document.documentElement.scrollTop;
    if (scro >= 260) {
        sc.className = "seckill-nav seckill-navfixed";
    } else {
        sc.className = "seckill-nav";
    }
}
