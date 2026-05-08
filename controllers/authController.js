const db = require('../database/connection');

exports.login = (req, res) => {

    const { email, senha } = req.body;

    const sql = `
        SELECT * FROM usuarios
        WHERE email = ? AND senha = ?
    `;

    db.query(sql, [email, senha], (err, result) => {

        if (err) {
            return res.status(500).json(err);
        }

        if (result.length > 0) {

            return res.json({
                success: true,
                usuario: result[0]
            });

        } else {

            return res.status(401).json({
                success: false,
                message: 'Email ou senha inválidos'
            });
        }
    });
};