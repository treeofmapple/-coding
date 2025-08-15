from diffusers import StableDiffusionPipeline

pipe = StableDiffusionPipeline.from_pretrained(
    "runwayml/stable-diffusion-v1-5",
    torch_dtype="float32"
).to("cpu")

image = pipe("a wooden chair in a minimalistic room").images[0]
image.save("chair.png")
