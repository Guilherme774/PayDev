import { openDb } from "../config/database.js";

export async function createTable() {
    openDb().then(db => {
        db.exec('CREATE TABLE IF NOT EXISTS User (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, password TEXT, balance decimal(10,2) DEFAULT 0.00)');
    })
}

export async function createUser(user) {
    openDb().then(db => { // Adicionando os parênteses para invocar a função openDb()
        db.run('INSERT INTO User(name, email, password, balance) VALUES(?, ?, ?, ?)', [user.name, user.email, user.password, user.balance]);
    })
}

export async function getUsers() {
    return openDb().then(db => { // Adicionando o retorno para a Promise ser propagada
        return db.all('SELECT id, name, email, balance FROM User');
    })
}

export async function getUserById(id) {
    return openDb().then(db => { // Adicionando o retorno para a Promise ser propagada
        return db.all('SELECT id, name, email, balance FROM User WHERE id = ?', [id]);
    })
}

export async function updateUser(user) {
    return openDb().then(db => { // Adicionando o retorno para a Promise ser propagada
        return db.run('UPDATE User SET name = ?, email = ?, balance = ? WHERE id = ?', [user.name, user.email, user.balance, user.id]);
    })
}

export async function deleteUser(id) {
    return openDb().then(db => { // Adicionando o retorno para a Promise ser propagada
        return db.all('DELETE FROM User WHERE id = ?', [id]);
    })
}