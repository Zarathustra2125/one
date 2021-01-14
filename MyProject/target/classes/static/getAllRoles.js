function getRoles() {
    fetch("http://localhost:8080/allRoles").then((res) => res.json())
        .then((data) => {
            let output = "";
            data.forEach(function (role) {
                output += `<option>${role.role}</option>`;
            });
            document.getElementById("roleNew").innerHTML;
            document.getElementById("roleEdit").innerHTML = output;
            document.getElementById("roleDelete").innerHTML = output;
        })
}

getRoles()