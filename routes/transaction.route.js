import express from 'express';
import { sendMoneyById } from '../controllers/transaction-controller.js';

const router = express.Router();

router.route('/:id').post(sendMoneyById);

export default router;