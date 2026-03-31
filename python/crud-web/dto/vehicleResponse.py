from pydantic import BaseModel
from pydantic.config import ConfigDict


class VehicleResponse(BaseModel):
    model_config = ConfigDict(from_attributes=True)

    id: int
    brand: str
    model: str
    color: str
    plate: str
