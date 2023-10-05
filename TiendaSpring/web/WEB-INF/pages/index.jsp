<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/web_war_exploded/resources/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/pages/menu.jsp"/>
</body>
<script src="/web_war_exploded/resources/jquery/jquery.min.js"></script>
<script src="/web_war_exploded/resources/bootstrap/bootstrap.min.js"></script>
<script>
    $(function() {
        $("#login").submit(function(e){
            $('#loginModal').modal('toggle');
            e.preventDefault();
            $.ajax({
                    type: 'GET',
                    url: $(this).attr('action'),
                    data: $(this).serialize(),
                    // Mostramos un mensaje con la respuesta de PHP
                    success: function(data) {
                        $('#result').html(data);
                    }
                });
            alert('algo');
        });
    });
</script>
</html>