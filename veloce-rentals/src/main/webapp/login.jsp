<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="styles.css">

</head>
<body>
<nav>
    <ul>
        <div >
            <img src="https://i.ibb.co/KxW1WFT/logo.png" />
        </div>
        <div class="ul__container">
            <li><a href="home">Inicio</a></li>
            <%
                if (request.getAttribute("username") == null) {
            %>
            <li><a href="login">Login</a></li>
            <li><a href="register">Register</a></li>
            <%
            } else {
            %>
            <li><a href="">Bienvenido,<span> ${username}</span> </a></li>
            <li><a href="logout">Cerrar sesión</a></li>
            <%
                }
            %>

        </div>
    </ul>
</nav>
<main>
    <div style="width: 100%; display: flex; justify-content: center">
        <form action="login" method="post">
            <h1>Inicia sesión</h1>
            <div class="input__row">
                <label for="email">Email:</label>
                <input type="email" name="email" id="email" required>
            </div>
            <div class="input__row">
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" required>
            </div>
            <div style="display: flex; justify-content: end">
                <button type="submit">Iniciar sesión</button>
            </div>
        </form>
    </div>
</main>
</body>
</html>
