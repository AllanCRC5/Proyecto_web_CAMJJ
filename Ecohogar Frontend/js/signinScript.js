document.getElementById("signinForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const userData = { //Agarra los datos del usuario por ID
        name: document.getElementById("name").value,
        memberQuantity: document.getElementById("memberQuantity").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        ecoService: {
            name: document.getElementById("ecoName").value,
            waterCostPerlit: document.getElementById("waterCostPerlit").value,
            hoursOfLightPd: document.getElementById("hoursOfLightPd").value,
            lightCostPerHour: document.getElementById("lightCostPerHour").value,
            litersOfWaterConsumedPd: document.getElementById("litersOfWaterConsumedPd").value
        },
        device: { //Datos del dispositivo
            name: document.getElementById("deviceName").value,
            usedLight: document.getElementById("usedLight").value,
            quantity: document.getElementById("quantity").value
        }
    };

    try { 
        const response = await fetch("https://proyecto-web-camjj-2.onrender.com/api/family/save", { //Cons response que hace fetch del save
            method: "POST", //Endpoint POST
            headers: { "Content-Type": "application/json" }, //Header
            body: JSON.stringify(userData) //Convierte los datos del usuario a string
        });

        const messageElement = document.getElementById("message"); //Constante mensaje

        if (response.ok) { //Si el response es "ok":
            const data = await response.json(); //Data toma el json del response
            messageElement.style.color = "green"; //Color verde de texto
            messageElement.textContent = "Cuenta creada con éxito. Bienvenido " + data.name; //Mensaje da bienvenida al usuario
        } else { //Si el response no es "ok":
            const error = await response.text(); //Constante error
            messageElement.style.color = "red"; //Color rojo de texto
            messageElement.textContent = error; //Contenido del mensaje = texto
        }
    } catch (err) { //Atrapa errores
        document.getElementById("message").textContent = "Error de conexión con el servidor";
    }
});