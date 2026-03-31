from pydantic import BaseModel

from .vehicleResponse import VehicleResponse

class PageVehicleResponse(BaseModel):
    content: list[VehicleResponse]
    page: int
    size: int
    total_pages: int
