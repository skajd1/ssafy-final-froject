import { ref, reactive, computed } from "vue";
import { defineStore } from "pinia";
import { getTripInfoById } from "@/api/TripApi.js";
import { getTripInfo } from "@/api/TripApi.js";

const useTripStore = defineStore("useTripStore", () => {
  const tripItems = ref([]);
  const selectedTrip = ref({});

  const initTripItems = () => {
    tripItems.value = [];
  };

  const key = ref("");

  const getTripItems = (cid) => {
    getTripInfoById(
      cid,
      (res) => {
        tripItems.value.push(res.data[0]);
      },
      (err) => {
        console.log(err);
      }
    );
  };

  const select = (trip) => {
    selectedTrip.value = trip;
  };
  const keyword = computed({
    get: () => key.value,
    set: (value) => (key.value = value),
  });
  const items = computed(() => tripItems.value);
  const selected = computed(() => selectedTrip.value);

  // 여행지 조회
  const tripList = ref([]);
  const searchdata = reactive({
    keyword: "",
    sido: "",
    gugun: "",
  });

  const sido = computed({
    get: () => searchdata.sido,
    set: (value) => (searchdata.sido = value),
  });

  const gugun = computed({
    get: () => searchdata.gugun,
    set: (value) => (searchdata.gugun = value),
  });

  const tema = computed({
    get: () => searchdata.gugun,
    set: (value) => (searchdata.tema = value),
  });

  const lists = computed(() => tripList.value);

  const getTripList = () => {
    getTripInfo(
      searchdata,
      (res) => {
        tripList.value = res.data;
      },
      (err) => {
        console.log(err);
      }
    );
  };

  return {
    initTripItems,
    getTripItems,
    select,
    keyword,
    items,
    selected,
    getTripList,
    lists,
    sido,
    gugun,
    tema,
  };
});

export { useTripStore };
