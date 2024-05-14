
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="styles.css">
</head>
<style>
  section{
    display: flex;
    flex-direction: column;
    height: auto;
    width: 100%;
    padding-top:3rem;
    padding-left: 3rem;
    padding-right: 3rem;
  }
  header{
    display: flex;
    flex-direction: column;
    gap: 1rem;
    width: 100%;
  }
  h1{
    font-size: 3rem;
    font-weight: 700;
  }
  .hero__image{
    width: 1000px;
    height: 700px;
  }
  .hero__container{
    display: flex;
    gap: 3rem;
    justify-content: space-between;
    align-items: center;
    flex-direction: row;

  }

</style>
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
  <section>
    <header>
        <h1>¡Bienvenido a Veloce Rentals!</h1>
        <p>Acá podras rentar los mejores vehículos de la ciudad</p>
    </header>
    <section class="hero__container">
      <a href="vehicles">
        <button>Ver vehiculos</button>
      </a>
      <div>
        <img src="https://i.ibb.co/843ghD0/hero.png" class="hero__image">
      </div>
    </section>

  </section>
</main>

</body>
</html>
