document.getElementById("loginForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const email = document.getElementById("email").value; //Constante que recibe el email
    const password = document.getElementById("password").value; //Constante que recibe la contraseña

    try { 
        const response = await fetch("http://localhost:8080/api/family/login", { //Constante response
            method: "POST", //El endpoint es un POST
            headers: { "Content-Type": "application/json" }, //Header
            body: JSON.stringify({ email, password }) //Convierte los datos a string
        });

        const messageElement = document.getElementById("message"); //Obtiene mensaje

        if (response.ok) { //Si el response es positivo:
            const data = await response.text();
            messageElement.style.color = "green"; //Color verde de mensaje
            messageElement.textContent = data; //Texto contiene los datos
        } else { //Si hay errores
            const error = await response.text(); //Constante de error que obtiene el texto de response
            messageElement.style.color = "red"; //COlor rojo de mensaje
            messageElement.textContent = error; //Mete el texto de cons error al contenido del mensaje
        }
    } catch (err) { //Atrapa errores
        document.getElementById("message").textContent = "Error de conexión con el servidor";
    }
});
