const url = "http://localhost:8080/getUser"

function getUser() {

    fetch(url).then((res) => res.json())
        .then((user) => {
            let userRoles = "";
            for (let i = 0; i < user.roles.length; i++) {
                userRoles += `${user.roles[i].role} `
            }

            let output = "<tr>";
            output += `
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
                <td>${user.mail}</td>
                <td>${userRoles}</td>
            `;
            output += "<tr>";

            document.getElementById("gUser").innerHTML = output;
        })
}

function getHeader() {
    fetch(url).then((res) => res.json())
        .then((user) => {
            let userRoles = "";
            for (let i = 0; i < user.roles.length; i++) {
                userRoles += `${user.roles[i].role} `
            }
            let output = "";
            output += `${user.mail} with roles: ${userRoles}`;
            document.getElementById("gHed").innerHTML = output;
        })
}

getHeader()
getUser()
