from pydantic import BaseModel


class VehicleUpdate(BaseModel):
    brand: str | None = None
    model: str | None = None
    color: str | None = None
    plate: str | None = None
