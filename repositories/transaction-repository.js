import { openDb } from "../config/database.js";

export async function updateUserBalance(transaction) {
    await openDb().then(db => {
        db.run('UPDATE User SET balance = balance - ? WHERE id = ?', [transaction.value, transaction.id_user_sender]);
    })

    await openDb().then(db => {
        db.run('UPDATE User SET balance = balance + ? WHERE id = ?', [transaction.value, transaction.id_user_receiver]);
    });
}