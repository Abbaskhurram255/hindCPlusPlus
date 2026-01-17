class Coords:
    _new(mera, lat: flt, lon: flt):
        mera.lat = lat agar lat he_kism flt warna 0.0
        mera.lon = lon agar lon he_kism flt warna 0.0
    _print_par(mujhe):
        return "(${mera.lat}, ${mera.lon})"
    _dev_print_par(mujhe):
        return "Coords" + me._str()
    _f(mera, format_spec ki kism<flt>):
        agar format_spec he "coords":
            return "Lat ${my.lat}, Lon: ${my.lon}"
        return ._str()

kism<Coords> c = nai Coords(10.121345, 20.67890)
kaho "Coordinates: $c"
kaho "Details: $c:coords mera"