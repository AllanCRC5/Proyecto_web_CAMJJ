
const API = "https://proyecto-web-camjj-2.onrender.com/api/family";

const tbody = document.querySelector("#familyTable tbody");
const filtro = document.getElementById("memberFilter");
const botonFiltro = document.getElementById("applyFilter");

let familias = [];

// ===============================
// Cargar todas las familias
// ===============================

async function cargarFamilias() {

    tbody.innerHTML = "";

    try {

        const response = await fetch(API);

        familias = await response.json();

        mostrarFamilias(familias);

    } catch (error) {

        console.error(error);

        tbody.innerHTML =
            "<tr><td colspan='5'>No se pudo cargar la información.</td></tr>";

    }

}

// ===============================
// Mostrar familias
// ===============================

async function mostrarFamilias(lista) {

    tbody.innerHTML = "";

    for (const familia of lista) {

        let agua = "";
        let luz = "";
        let eco = "";

        try {

            const aguaResponse = await fetch(API + "/agua/" + familia.id);
            agua = await aguaResponse.text();

            const luzResponse = await fetch(API + "/luz/" + familia.id);
            luz = await luzResponse.text();

            const ecoResponse = await fetch(API + "/eco-indice/" + familia.id);
            eco = await ecoResponse.text();

        } catch (error) {

            agua = "Error";
            luz = "Error";
            eco = "Error";

        }

        tbody.innerHTML += `
            <tr>
                <td>${familia.name}</td>
                <td>${familia.memberQuantity}</td>
                <td>${agua}</td>
                <td>${luz}</td>
                <td>${eco}</td>
            </tr>
        `;

    }

}


// ===============================
// Aplicar filtro
// ===============================

botonFiltro.addEventListener("click", () => {

    const valor = filtro.value;

    let resultado = [];

    if (valor === "all") {

        resultado = familias;

    } else if (valor === "1-3") {

        resultado = familias.filter(f =>
            f.memberQuantity >= 1 &&
            f.memberQuantity <= 3
        );

    } else if (valor === "4-6") {

        resultado = familias.filter(f =>
            f.memberQuantity >= 4 &&
            f.memberQuantity <= 6
        );

    } else {

        resultado = familias.filter(f =>
            f.memberQuantity >= 7
        );

    }

    mostrarFamilias(resultado);

});

// ===============================
// Iniciar
// ===============================

cargarFamilias();