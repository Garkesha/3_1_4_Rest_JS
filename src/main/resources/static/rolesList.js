function rolesList(user) {
    let rolesList = document.createElement('ul');

    for (let i = 0; i < user.userRoles.length; i++) {
        let role = document.createElement('li');
        role.textContent = user.userRoles[i].roleName.substring(5, 10) + " ";
        rolesList.appendChild(role);
    }
    return rolesList;
}