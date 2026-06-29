const API = "http://localhost:8080/api/family";

const form = document.getElementById("loginForm");
const message = document.getElementById("message");

form.addEventListener("submit", async function (e) {

    e.preventDefault();

    const usuario = {
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };

    try {

        const respuesta = await fetch(API + "/login", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(usuario)

        });

        const datos = await respuesta.text();

        if (respuesta.ok) {

            message.style.color = "green";
            message.innerHTML = datos;

            setTimeout(() => {

                window.location.href = "index.html";

            }, 1500);

        } else {

            message.style.color = "red";
            message.innerHTML = datos;

        }

    } catch (error) {

        console.error(error);

        message.style.color = "red";
        message.innerHTML = "No fue posible conectar con el servidor.";

    }

});