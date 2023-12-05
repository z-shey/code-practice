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


// $(document).ready(function() {
//     // 监听侧边栏菜单项的点击事件
//     $('.sidebar_menu a').on('click', function(e) {
//         e.preventDefault(); // 阻止默认行为
//
//         var page = $(this).data('page'); // 获取data-page属性值
//         if (page) {
//             // 使用AJAX请求获取对应的JSP页面内容
//             $.ajax({
//                 url: page, // 这里的page变量就是JSP页面的路径
//                 type: 'GET',
//                 success: function(response) {
//                     // 将获取到的内容加载到 .content 元素中
//                     $('.content').html(response);
//                 },
//                 error: function(xhr, status, error) {
//                     // 可以在这里处理错误，比如显示一个错误消息
//                     console.error("An error occurred: " + error);
//                 }
//             });
//         }
//     });
// });



//
// $(document).ready(function() {
//     // 假设 .default-content 是您希望在点击“工作区”时显示的默认内容
//     var defaultContent = $(".content").html(); // 保存默认内容
//
//     $('.sidebar_menu a').on('click', function(e) {
//         e.preventDefault(); // 阻止默认行为
//
//         var page = $(this).data('page'); // 获取data-page属性值
//         if (page) {
//             // 使用AJAX请求获取对应的JSP页面内容
//             $.ajax({
//                 url: page, // 这里的page变量就是JSP页面的路径
//                 type: 'GET',
//                 success: function(response) {
//                     // 将获取到的内容加载到 .content 元素中
//                     $('.content').html(response);
//                 },
//                 error: function(xhr, status, error) {
//                     // 可以在这里处理错误，比如显示一个错误消息
//                     console.error("An error occurred: " + error);
//                 }
//             });
//         } else {
//             // 如果没有data-page属性，即用户点击的是“工作区”，则加载默认内容
//             $('.content').html(defaultContent);
//         }
//     });
// });


// $(document).ready(function() {
//     $('.nav-link').click(function(e) {
//         e.preventDefault(); // 阻止默认链接跳转行为
//
//         // 获取data-servlet属性值，它指明了要请求的Servlet
//         var servletName = $(this).data('servlet');
//
//         // 使用AJAX请求对应的Servlet
//         $.ajax({
//             url: '/' + servletName, // 假设Servlet映射到 "/servletName"
//             type: 'GET',
//             success: function(response) {
//                 // 将返回的内容插入到主容器中
//                 $('.main_container .content').html(response);
//             },
//             error: function(xhr, status, error) {
//                 // 处理错误
//                 console.error("An error occurred: " + status + "\nError: " + error);
//             }
//         });
//     });
// });


$(document).ready(function() {
    var defaultContent = $(".content").html(); // 保存默认内容
    $('.nav-link').click(function(e) {
        e.preventDefault(); // 阻止默认链接跳转行为

        // 检查是否点击了工作区
        if (this.id === 'workArea') {
            // 显示默认内容或执行其他操作
            $('.content').html(defaultContent);
        } else {
            // 获取data-servlet属性值，它指明了要请求的Servlet
            var servletName = $(this).data('servlet');

            // 使用AJAX请求对应的Servlet
            $.ajax({
                url: '/' + servletName, // 假设Servlet映射到 "/servletName"
                type: 'GET',
                success: function(response) {
                    // 将返回的内容插入到主容器中
                    $('.main_container .content').html(response);
                },
                error: function(xhr, status, error) {
                    // 处理错误
                    console.error("An error occurred: " + status + "\nError: " + error);
                }
            });
        }
    });
});
