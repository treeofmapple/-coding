from fastapi import APIRouter, Response, status

from dto.vehiclePageResponse import PageVehicleResponse
from dto.vehicleRequest import VehicleRequest
from dto.vehicleResponse import VehicleResponse
from dto.vehicleUpdate import VehicleUpdate
from service.vehicleService import vehicle_service

router = APIRouter(prefix="/v1/vehicle", tags=["Vehicle"])


@router.get("/search", response_model=PageVehicleResponse)
def find_by_pages(page: int = 0):
    return vehicle_service.find_by_pages(page)


@router.get("/{id}", response_model=VehicleResponse)
def find_vehicle_by_id(id: int):
    return vehicle_service.find_by_id(id)


@router.post("", response_model=VehicleResponse, status_code=status.HTTP_201_CREATED)
def create_vehicle(request: VehicleRequest):
    return vehicle_service.create_vehicle(request)


@router.put(
    "/{id}", response_model=VehicleResponse, status_code=status.HTTP_202_ACCEPTED
)
def update_vehicle(id: int, request: VehicleUpdate):
    return vehicle_service.update_vehicle(id, request)


@router.delete("/{plate}", status_code=status.HTTP_204_NO_CONTENT)
def delete_vehicle(plate: str):
    vehicle_service.delete_vehicle_by_plate(plate)
    return Response(status_code=status.HTTP_204_NO_CONTENT)
