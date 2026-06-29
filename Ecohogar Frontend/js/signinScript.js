const API_USER = "https://proyecto-web-camjj-2.onrender.com/api/family";
const API_DEVICE = "https://proyecto-web-camjj-2.onrender.com//api/EcoHogar";
const API_SERVICE = "https://proyecto-web-camjj-2.onrender.com/api/EcoHogar/service";

const form = document.getElementById("signinForm");
const message = document.getElementById("message");

form.addEventListener("submit", async function (e) {

    e.preventDefault();

    try {

        // ==========================
        // Registrar Dispositivo
        // ==========================

        const device = {
            name: document.getElementById("deviceName").value,
            usedLigth: parseFloat(document.getElementById("usedLight").value),
            quantity: parseFloat(document.getElementById("quantity").value)
        };

        await fetch(API_DEVICE + "/add", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(device)
        });

        // ==========================
        // Registrar Servicio
        // ==========================

        const ecoService = {
            name: document.getElementById("ecoName").value,
            waterCostPerlit: parseFloat(document.getElementById("waterCostPerlit").value),
            hoursOfLightPd: parseFloat(document.getElementById("hoursOfLightPd").value),
            lightCostPerHour: parseFloat(document.getElementById("lightCostPerHour").value),
            litersOfWaterConsumedPd: parseFloat(document.getElementById("litersOfWaterConsumedPd").value)
        };

        await fetch(API_SERVICE + "/save", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(ecoService)
        });

        // ==========================
        // Registrar Usuario
        // ==========================

        const user = {
            name: document.getElementById("name").value,
            memberQuantity: parseInt(document.getElementById("memberQuantity").value),
            email: document.getElementById("email").value,
            password: document.getElementById("password").value
        };

        const response = await fetch(API_USER + "/save", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(user)
        });

        if (response.ok) {

            message.style.color = "green";
            message.textContent = "Usuario registrado correctamente.";

            form.reset();

            setTimeout(() => {
                window.location.href = "login.html";
            }, 2000);

        } else {

            const error = await response.text();

            message.style.color = "red";
            message.textContent = error;

        }

    } catch (error) {

        console.error(error);

        message.style.color = "red";
        message.textContent = "Error al conectar con el servidor.";

    }

});