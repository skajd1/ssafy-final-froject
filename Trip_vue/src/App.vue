<script setup>
import { RouterView } from "vue-router";
import { useRoute } from "vue-router";
import Header from "@/components/common/Header.vue";
import spinner from "@/components/common/Spinner.vue";
import { ref, watch } from "vue";
import Footer from "@/components/common/Footer.vue";
import { useUserStore } from "@/stores/userStore";
import { storeToRefs } from "pinia";

const userStore = useUserStore();
const { load } = storeToRefs(userStore);

const route = useRoute();
const name = ref("");
const LoadingStatus = ref(false);

watch(
  route,
  () => {
    name.value = route.name;
  },
  { deep: true }
);

watch(
  load,
  () => {
    LoadingStatus.value = load.value;
  },
  { deep: true }
);
</script>

<template>
  <spinner v-if="LoadingStatus"></spinner>
  <Header v-if="name !== 'Home'"></Header>

  <RouterView />

  <!-- <Footer></Footer> -->
</template>

<style>
:root {
  --main-color: #ffa18d;
  --main-color-bg: #f5d7cdff;
}
</style>
