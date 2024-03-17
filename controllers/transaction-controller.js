import { Transaction } from "../models/transaction.js";
import { getUserById } from "../repositories/user-repositories.js";
import { updateUserBalance } from "../repositories/transaction-repository.js";

export async function sendMoneyById(req, res) {
    try {
        const id = req.params.id;
        const { id_user_receiver, value } = req.body;

        const transaction = new Transaction();
        const user = await getUserById(id);
        const userReceiver = await getUserById(id_user_receiver);

        if(id == id_user_receiver) return res.send({ message: 'You cannot send money to yourself', statusCode: 400 });

        if(user.length <= 0 || userReceiver.length <= 0) {
            return res.send({message: 'User not found!', statusCode: 404});
        }
        if(value <= 0) {
            return res.send({message: 'Invalid value!', statusCode: 400});
        }
        if(user[0].balance < value) {
            return res.send({message: 'Insufficient balance!', statusCode: 400});
        }

        transaction.id_user_sender = id;
        transaction.id_user_receiver = id_user_receiver;
        transaction.value = value;
        transaction.date = new Date();

        await updateUserBalance(transaction);

        res.send(transaction);
    }
    catch (error) {
        res.send(error);
    }
}