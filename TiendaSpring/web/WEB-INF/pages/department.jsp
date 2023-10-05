<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../resources/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/pages/menu.jsp"/>

<div>
    <c:forEach var="value" items="${items}">
    <div class="col-lg-4 col-md-6 col-xs-12">
        <div class="panel panel-info">
            <div class="panel-body">
                <div class="text-center">
                    <img src="/web_war_exploded/${value.getImage()}">
                </div>
                <div class="text-center">${value.getDescription()}</div>
                <div class="text-center">$${value.getPrice()}</div>
                <div class="text-center">
                    <button class="btn btn-success">Agregar al carro</button>
                </div>
            </div>
        </div>
    </div>
    </c:forEach>
</div>
</body>
<script src="../resources/jquery/jquery.min.js"></script>
<script src="../resources/bootstrap/bootstrap.min.js"></script>
<script>
    $(function() {
        function addToCar(item) {
            $.ajax({
                type: 'POST',
                url: "/addCar/"+item,
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