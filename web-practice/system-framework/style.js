$(document).ready(function () {
    $(".sidebar_menu li").click(function () {
        $(".sidebar_menu li").removeClass("active");
        $(this).addClass("active");
    })
    $(".hamburger").click(function () {
        $(".wrapper").addClass("active");
    })
    $(".bg_shadow,.close").click(function () {
        $(".wrapper").removeClass("active");
    })
})

