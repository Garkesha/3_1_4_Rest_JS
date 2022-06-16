showHeader()

function showHeader() {
    fetch('http://localhost:8080/info')
        .then(response => response.json())
        .then(user => {
            document.getElementById("header_username").innerHTML = user.username;
            document.getElementById("header_roles").innerHTML = 'with roles: ' + rolesList(user).textContent;
        });
}