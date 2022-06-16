userInfo()

function userInfo(user) {
    fetch('http://localhost:8080/info')
        .then(response => response.json())
        .then(user => {
            let tBody = document.getElementById("user_info");
            tBody.innerHTML = "";

            var row = tBody.insertRow(0);
            var cell0 = row.insertCell(0);
            cell0.innerHTML = user.id;
            var cell1 = row.insertCell(1);
            cell1.innerHTML = user.username;
            var cell2 = row.insertCell(2);
            cell2.innerHTML = user.name;
            var cell3 = row.insertCell(3);
            cell3.innerHTML = user.lastname;
            var cell4 = row.insertCell(4);
            cell4.innerHTML = user.age;
            var cell5 = row.insertCell(5);
            cell5.innerHTML = rolesList(user).textContent
        })
}