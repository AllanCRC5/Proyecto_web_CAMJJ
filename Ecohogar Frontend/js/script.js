  async function loadFamilies() {
      const response = await fetch("http://localhost:8080/api/family");
      const families = await response.json();
      renderTable(families);
    }

    function renderTable(families) {
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

    document.getElementById("applyFilter").addEventListener("click", async () => {
      const filter = document.getElementById("memberFilter").value;
      const response = await fetch("http://localhost:8080/api/family");
      const families = await response.json();
      let filtered = families;

      if (filter === "1-3") filtered = families.filter(f => f.memberQuantity <= 3);
      else if (filter === "4-6") filtered = families.filter(f => f.memberQuantity >= 4 && f.memberQuantity <= 6);
      else if (filter === "7+") filtered = families.filter(f => f.memberQuantity >= 7);

      renderTable(filtered);
    });

    loadFamilies();