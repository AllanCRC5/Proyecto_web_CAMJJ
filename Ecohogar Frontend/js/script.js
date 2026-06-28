  async function loadFamilies() {  //Cargar familias
      const response = await fetch("http://localhost:8080/api/family"); //crea una constante llamada response que recibe el url
      const families = await response.json(); //crea constante llamada families que agarra el json de response
      renderTable(families);
    }

    function renderTable(families) { //Renderiza la tabla
      const tbody = document.querySelector("#familyTable tbody"); 
      tbody.innerHTML = "";
      families.forEach(f => {
        const row = document.createElement("tr");
        row.innerHTML = `
          <td>${f.name}</td>
          <td>${f.memberQuantity}</td>
          <td>${f.ecoService?.litersOfWaterConsumedPd * 30 || 0} L</td>
          <td>${f.ecoService?.hoursOfLightPd * 30 || 0} h</td>
          <td>${f.ecoIndex || "N/A"}</td>
        `;
        tbody.appendChild(row);
      });
    }

    document.getElementById("applyFilter").addEventListener("click", async () => { //Recibe el click de apply filter
      const filter = document.getElementById("memberFilter").value; //constante filter que recibe el valor del filtro
      const response = await fetch("http://localhost:8080/api/family"); //constante response que hace fetch del url de localhost
      const families = await response.json(); //constante families que agarra el json de response
      let filtered = families;

      //Condiciones if para los filtros de tamaño de familia
      if (filter === "1-3") filtered = families.filter(f => f.memberQuantity <= 3); 
      else if (filter === "4-6") filtered = families.filter(f => f.memberQuantity >= 4 && f.memberQuantity <= 6);
      else if (filter === "7+") filtered = families.filter(f => f.memberQuantity >= 7);

      renderTable(filtered); //Renderiza la tabla
    });

    loadFamilies(); //Carga las familias ya filtradas