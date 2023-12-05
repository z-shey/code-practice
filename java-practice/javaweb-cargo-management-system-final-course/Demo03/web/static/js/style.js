$(document).ready(function () {
    $('form').submit(function (event) {
        var userName = $('#userName').val();
        var password = $('#password').val();

        if (userName.trim() === '' && password.trim() !== '') {
            event.preventDefault();
            alert('请输入用户名');
        } else if (userName.trim() !== '' && password.trim() === '') {
            event.preventDefault();
            alert('请输入密码');
        } else if (userName.trim() === '' && password.trim() === '') {
            event.preventDefault();
            alert('请输入用户名和密码');
        }
    });
});
