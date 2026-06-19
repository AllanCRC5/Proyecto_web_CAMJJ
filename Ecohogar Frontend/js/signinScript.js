document.getElementById("signinForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const userData = {
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
        device: {
            name: document.getElementById("deviceName").value,
            usedLight: document.getElementById("usedLight").value,
            quantity: document.getElementById("quantity").value
        }
    };

    try {
        const response = await fetch("http://localhost:8080/api/family/save", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(userData)
        });

        const messageElement = document.getElementById("message");

        if (response.ok) {
            const data = await response.json();
            messageElement.style.color = "green";
            messageElement.textContent = "Cuenta creada con éxito. Bienvenido " + data.name;
        } else {
            const error = await response.text();
            messageElement.style.color = "red";
            messageElement.textContent = error;
        }
    } catch (err) {
        document.getElementById("message").textContent = "Error de conexión con el servidor";
    }
});