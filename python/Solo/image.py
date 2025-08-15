from PIL import Image
import os

pasta = "imagens"  # <- Troque pelo nome da sua pasta

extensoes_validas = ('.jpg', '.jpeg', '.png', '.bmp', '.tiff')
arquivos_imagem = [f for f in os.listdir(pasta) if f.lower().endswith(extensoes_validas)]

arquivos_imagem.sort()

caminhos_imagem = [os.path.join(pasta, f) for f in arquivos_imagem]

imagens = [Image.open(caminho).convert("RGB") for caminho in caminhos_imagem]

if imagens:
    primeira = imagens[0]
    restantes = imagens[1:]
    primeira.save("resultado.pdf", save_all=True, append_images=restantes)
    print("PDF criado com sucesso!")
else:
    print("Nenhuma imagem encontrada na pasta.")
