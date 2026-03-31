from pydantic import BaseModel, Field


class VehicleRequest(BaseModel):
    brand: str = Field(..., min_length=1)
    model: str = Field(..., min_length=1)
    color: str = Field(..., min_length=1)
    plate: str = Field(..., min_length=1)
