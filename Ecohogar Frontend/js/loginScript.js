
document.getElementById("loginForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
        const response = await fetch("http://localhost:8080/api/family/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ email, password })
        });

        const messageElement = document.getElementById("message");

        if (response.ok) {
            const data = await response.text();
            messageElement.style.color = "green";
            messageElement.textContent = data;
        } else {
            const error = await response.text();
            messageElement.style.color = "red";
            messageElement.textContent = error;
        }
    } catch (err) {
        document.getElementById("message").textContent = "Error de conexión con el servidor";
    }
});
