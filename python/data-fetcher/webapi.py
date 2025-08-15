from flask import Flask, request, jsonify
from flask_cors import CORS
import pandas as pd
import os

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PATH = os.path.join(SCRIPT_DIR, "Relatorio_cadop.csv")

app = Flask(__name__)
CORS(app, resources={r"/*": {'origins': "*"}})

def load_data():
    try:
        df = pd.read_csv(PATH, on_bad_lines="skip", delimiter=";", engine="python")
        return df
    except Exception as e:
        print(f"Erro ao carregar o CSV: {e}")
        return pd.DataFrame()

@app.route('/buscar', methods=['GET'])
def buscar_operadoras():
    texto_busca = request.args.get('texto', '').strip()
    texto_busca = texto_busca.replace('%', ' ')
    
    print(f"Received search query: '{texto_busca}'")
    
    df = load_data()
    
    if df.empty:
        return jsonify({"message": "Erro ao carregar os dados do CSV."}), 500
    
    if not texto_busca:
        return jsonify({"message": "Texto de busca não fornecido."}), 400
    
    resultados = df[df['Razao_Social'].str.contains(texto_busca, case=False, na=False, regex=False)]
    
    results_list = resultados.to_dict(orient='records')
    print(f"Returning {len(results_list)} results")
    return jsonify(results_list)

if __name__ == '__main__':
    app.run(debug=True, port=5000)
