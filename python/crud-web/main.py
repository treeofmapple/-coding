from fastapi import FastAPI
import uvicorn
from controller.vehicleController import router as vehicle_router

app = FastAPI(title="Vehicle API")

app.include_router(vehicle_router)

if __name__ == "__main__":
    uvicorn.run(app, host="0.0.0.0", port=5000)
