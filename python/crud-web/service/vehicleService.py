import math
from typing import Union

from fastapi import HTTPException

from dto.vehiclePageResponse import PageVehicleResponse
from dto.vehicleRequest import VehicleRequest
from dto.vehicleResponse import VehicleResponse
from dto.vehicleUpdate import VehicleUpdate

PAGE_SIZE = 20
VehicleData = dict[str, Union[str, int, None]]


class VehicleService:
    _db: dict[int, VehicleData]
    _current_id: int

    def __init__(self):
        self._db = {}
        self._current_id = 1

    def find_by_pages(self, page: int) -> PageVehicleResponse:
        all_vehicles = list(self._db.values())

        start = page * PAGE_SIZE
        end = start + PAGE_SIZE
        content = [VehicleResponse.model_validate(v) for v in all_vehicles[start:end]]

        total_pages = math.ceil(len(all_vehicles) / PAGE_SIZE)

        return PageVehicleResponse(
            content=content, page=page, size=PAGE_SIZE, total_pages=total_pages
        )

    def find_by_id(self, vehicle_id: int) -> VehicleResponse:
        vehicle = self._db.get(vehicle_id)
        if not vehicle:
            raise HTTPException(
                status_code=404, detail=f"Vehicle with id '{vehicle_id}' was not found."
            )
        return VehicleResponse.model_validate(vehicle)

    def create_vehicle(self, request: VehicleRequest) -> VehicleResponse:
        if any(v["plate"] == request.plate for v in self._db.values()):
            raise HTTPException(
                status_code=400,
                detail=f"A vehicle with plate '{request.plate}' already exists.",
            )

        new_id = self._current_id
        vehicle_dict = request.model_dump()
        vehicle_dict["id"] = new_id

        self._db[new_id] = vehicle_dict
        self._current_id += 1

        return VehicleResponse.model_validate(vehicle_dict)

    def update_vehicle(
        self, vehicle_id: int, request: VehicleUpdate
    ) -> VehicleResponse:
        if vehicle_id not in self._db:
            raise HTTPException(status_code=404, detail="Vehicle was not found")

        if request.plate:
            conflict = any(
                v["plate"] == request.plate and v["id"] != vehicle_id
                for v in self._db.values()
            )
            if conflict:
                raise HTTPException(status_code=400, detail="Plate already in use")

        update_data = request.model_dump(exclude_unset=True)
        self._db[vehicle_id].update(update_data)

        return VehicleResponse.model_validate(self._db[vehicle_id])

    def delete_vehicle_by_plate(self, plate: str) -> None:
        vehicle_id = next(
            (id for id, v in self._db.items() if v["plate"] == plate), None
        )
        if vehicle_id is None:
            raise HTTPException(
                status_code=404, detail=f"Vehicle with plate '{plate}' does not exist."
            )

        del self._db[vehicle_id]


vehicle_service = VehicleService()
