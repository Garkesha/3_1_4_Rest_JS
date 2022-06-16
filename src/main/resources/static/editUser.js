function editUser() {

    let form = window.formEditUser.editRoles;
    let new_Roles = [];

    let rolesList = document.createElement('ul');

    for (var i = 0; i < form.length; i++) {
        var option = form.options[i];
        let role = document.createElement('li');
        if (option.selected) {
            new_Roles[i] = option.value

            role.textContent = option.value.substring(5, 10) + " ";
            rolesList.appendChild(role);
        }
    }

    let id = window.formEditUser.editID.value;

    fetch('http://localhost:8080/admin/users/' + id, {
        method: 'PUT',
        body: JSON.stringify({
            id: window.formEditUser.editID.value,
            name: window.formEditUser.editName.value,
            lastName: window.formEditUser.editLastName.value,
            age: window.formEditUser.editAge.value,
            username: window.formEditUser.editUsername.value,
            password: window.formEditUser.editPassword.value,
            userRoles: new_Roles
        }),
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })
        .then(response => {
            $('#' + id).replaceWith('<tr id=' + id + '>' +
                '<td>' + id + '</td>' +
                '<td>' + window.formEditUser.editName.value + '</td>' +
                '<td>' + window.formEditUser.editLastName.value + '</td>' +
                '<td>' + window.formEditUser.editAge.value + '</td>' +
                '<td>' + window.formEditUser.editUsername.value + '</td>' +
                '<td>' + rolesList.textContent + '</td>' +
                '<td> <button type="button" onclick="modalEdit(' + id + ')" class="btn btn-primary btn-sm">Edit</button> </td>' +
                '<td> <button type="button" onclick="modalDelete(' + id + ')" class="btn btn-danger btn-sm">Delete</button> </td>' +
                '</tr>');
        });
}